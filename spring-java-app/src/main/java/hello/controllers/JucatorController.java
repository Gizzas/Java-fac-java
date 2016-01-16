package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class JucatorController {
  private List<Jucator> jucatori = new ArrayList<Jucator>();

  JucatorController() {
      Jucator j1 = new Jucator(1,"Tanase",27);
      Jucator j2 = new Jucator(2,"Messi",28);
      Jucator j3 = new Jucator(3,"Banel",31);
      Jucator j4 = new Jucator(4,"Borcea",40);
	
	jucatori.add(j1);
	jucatori.add(j2);
	jucatori.add(j3);
	jucatori.add(j4);
	
  }

  @RequestMapping(value="/jucatori", method = RequestMethod.GET)
  public List<Jucator> index() {
    return this.jucatori;
  }

  @RequestMapping(value="/jucatori/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Jucator p : this.jucatori) {
      if(p.getId() == id) {
        return new ResponseEntity<Jucator>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/jucatori/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Jucator p : this.jucatori) {
      if(p.getId() == id) {
        this.jucatori.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/jucatori/{id}",method = RequestMethod.PUT)
   public ResponseEntity update(@PathVariable("id") int id) {
	   for(Jucator p : this.jucatori){
		   if(p.getId() == id) {
			  
			   return new ResponseEntity<Jucator>(p,new HttpHeaders(), HttpStatus.OK);
		   }
	   }
	   return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

@RequestMapping(value="/Jucator/{id}/{nume}/{varsta}", method = RequestMethod.POST)
 public List<Jucator> create(@PathVariable(value="id") int id,@PathVariable(value="nume") String nume,@PathVariable(value="varsta") int varsta) {
  Jucator ji= new Jucator (id,nume,varsta);
  jucatori.add(ji);
  return this.jucatori;
 }

}