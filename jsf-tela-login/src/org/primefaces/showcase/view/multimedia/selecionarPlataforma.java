package org.primefaces.showcase.view.multimedia;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class selecionarPlataforma {

	private List<String> images;
	private String option;

	@PostConstruct
	public void init() {
		images = new ArrayList<String>();

		for (int i = 1; i <= 4; i++) {
			images.add("jogoXbox" + i + ".jpg");

		}

		for (int i = 1; i <= 4; i++) {
			images.add("ps4" + i + ".jpg");
		}

		for (int i = 1; i <= 4; i++) {
			images.add("wii" + i + ".jpg");
		}

	}

	public List<String> getImages() {
		return images;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		FacesContext context = FacesContext.getCurrentInstance();
		String mensagem = "";
		if (option != null && !option.equals("")) {
			images = new ArrayList<String>();
			if (option.equals("JogoXbox")) {
				for (int i = 1; i <= 4; i++) {
					images.add("jogoXbox" + i + ".jpg");

				}
			} else if (option.equals("ps4")) {
				for (int i = 1; i <= 4; i++) {
					images.add("ps4" + i + ".jpg");
				}
			} else if (option.equals("wii")) {
				for (int i = 1; i <= 4; i++) {
					images.add("wii" + i + ".jpg");
				}
			}
			mensagem = "Plataforma selecionada com sucesso";
		} else {
			mensagem = "Todas as plataformas selecionadas";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, option , mensagem));
		this.option = option;
	}
}