package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import daos.HospitalDAO;
import daos.PessoaDAO;
import models.Hospital;
import models.Pessoa;
@Controller
public class HospitalController {
	@RequestMapping("/hospital/formHospital") // aqui e o link que ta aparecendo
	public String form() {
		System.out.println("chamou o form de hospital");
	return "hospital/formHospital"; //para entender para sempre
	//aqui é chamado a pagina
}

//
	@PostMapping("/hospital")
	public String adicionar(Hospital hospital)
	{
		HospitalDAO pdao =  new HospitalDAO();
		pdao.inserir(hospital);
		System.out.println("adicionou o hospital ");
		return "redirect:hospital";
	}
	
}
