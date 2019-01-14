package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.HospitalDAO;
import daos.PessoaDAO;
import models.Hospital;
import models.Pessoa;

@Controller
public class PessoaController {

	
	
	@RequestMapping("/pessoa/formPessoa")
	public ModelAndView form() {
		System.out.println("chamou o form de pessoa");
		
		HospitalDAO hDAO = new HospitalDAO();
		List<Hospital> listandHospital = hDAO.getLista();
		ModelAndView model = new ModelAndView("pessoa/formPessoa");
	    model.addObject("hospital", listandHospital);
		return model;
}

//
	@PostMapping("/pessoa")
	public String adicionar(Pessoa pessoa)
	{
		PessoaDAO pdao =  new PessoaDAO();
		pdao.inserir(pessoa);
		System.out.println("adicionou o cara ");
		return "redirect:pessoa";
	}
	
	@GetMapping("/pessoa")
	public ModelAndView listar() {
	System.out.println("chamou a lsitagem de pessoa");
		PessoaDAO pdao = new PessoaDAO();
		List<Pessoa> lista = pdao.getLista();
		ModelAndView model = new ModelAndView("pessoa/list");
		model.addObject("pessoa", lista);
		return model;
	}
	
	
}
