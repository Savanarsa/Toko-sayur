/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum1.praktikum1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dell
 */
@Controller
public class ProjectController {
    
    @RequestMapping("input")
    public String getData (HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");
        
        String inputprice = data.getParameter("var_price");
        
        String inputquantity = data.getParameter("var_quantity");
        
        String diskone = "";
        
        Double iPrice = Double.valueOf(inputprice);
        Double iTotal = Double.valueOf(inputquantity);
        Double PriceTotal = iPrice * iTotal;
        Double getTotal = null;
        
        if (PriceTotal < 16000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskone = "0%";
        }
        else if (PriceTotal >= 16000 && PriceTotal < 25000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskone = "10%";
        }
        else if (PriceTotal >= 25000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskone = "15%";
        }
        
        String uangcustomer = data.getParameter("Var_uang");
        String Hasil = "";
        
        Double Ucustomer = Double.valueOf(uangcustomer);
        Double Upas = null;
        Double Ukembalian = null; 
        Double Ukurang = null;
        
        if (Ucustomer > getTotal)
        {
            Ukembalian = Ucustomer - getTotal;
            Hasil = "Uang anda dapat kembalian Rp."+Ukembalian;
        }
        else if (Ucustomer < getTotal)
        {
            Ukurang = Ucustomer - getTotal;
            Hasil = "Uang anda kurang, anda harus membayar lagi sebesar Rp."+Ukurang;
        }
        else if (Ucustomer == getTotal)
        {
            Hasil = "Uang anda pas";
        }
                         
        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("total", getTotal);
        discountprocess.addAttribute("diskone", diskone);
        discountprocess.addAttribute("UCus", Ucustomer);
        discountprocess.addAttribute("Hasil", Hasil);
        
        return "SavanaRizqiSukmaA";
    }
}