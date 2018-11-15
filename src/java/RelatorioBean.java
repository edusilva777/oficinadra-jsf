
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
@ManagedBean
public class RelatorioBean {
    
    public void pdf(List<Produto> produtos) throws JRException, IOException{

        
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(produtos);
        String caminhoReport = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/report1.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoReport,new HashMap<>(), beanCollectionDataSource);
        
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment;filename=report.pdf");
        
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
        
    }
    
}
