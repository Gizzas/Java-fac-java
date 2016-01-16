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
public class TemaController {
  private List<Tema> teme = new ArrayList<Tema>();

  OraseController() {
      Tema t1 = new Tema(1,"CSS",5);
      Tema t2 = new Tema(2,"Angularjs",8);
      Tema t3 = new Tema(3,"Java",7);
      Tema t4 = new Tema(4,"github",10);
	
      teme.add(t1);
      teme.add(t2);
      teme.add(t3);
      teme.add(t4);
    
  }

  @RequestMapping(value="/teme", method = RequestMethod.GET)
  public List<Tema> index() {
    return this.teme;
  }

  @RequestMapping(value="/teme/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Tema p : this.teme) {
      if(p.getId() == id) {
        return new ResponseEntity<Orase>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/teme/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Tema p : this.teme) {
      if(p.getId() == id) {
        this.teme.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/teme/{id}",method = RequestMethod.PUT)
   public ResponseEntity update(@PathVariable("id") int id) {
	   for(Tema p : this.teme){
		   if(p.getId() == id) {
			   
			   return new ResponseEntity<Orase>(p,new HttpHeaders(), HttpStatus.OK);
		   }
	   }
	   return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

@RequestMapping(value="/Tema/{id}/{nume}/{nota}", method = RequestMethod.POST)
 public List<Tema> create(@PathVariable(value="id") int id,@PathVariable(value="nume") String nume,@PathVariable(value="an") int an) {
  Tema t= new Tema (id,nume,nota);
  teme.add(t);
  return this.teme;
 }

}