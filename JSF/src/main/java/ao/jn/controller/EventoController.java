package ao.jn.controller;

import ao.jn.model.Evento;
import org.primefaces.event.RowEditEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@ManagedBean
@Named
@SessionScoped
public class EventoController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Evento evento;
    private List<Evento> eventos = new ArrayList<>();

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public String adiconarEvento(){
        eventos.add(evento);
        System.out.println("Evento " + evento.getNome() + " adicionado com sucesso!");
        clear();
        return "";
    }

    public void clear(){
        this.evento = new Evento();
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Evento Editado", String.valueOf(event.getObject()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Evento Cancelado", String.valueOf(event.getObject()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
