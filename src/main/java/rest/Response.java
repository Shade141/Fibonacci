package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Response {
	//Map Http requests with /calc to Calc method
	@RequestMapping(value="/calc", method=RequestMethod.GET)
	//binds values of the query to Java parameter
	public ResponseEntity<Calc> calc(@RequestParam(value="top", defaultValue="8") String top) {
		int value;
		//test if top is a Integer Number
		try {
			value = Integer.parseInt(top);
		}
		//if not respond with BAD_REQUEST
		catch (NumberFormatException e) {
			return new ResponseEntity<Calc>(HttpStatus.BAD_REQUEST);
		}
		//test if top below 1 if it is respond with BAD_REQUEST
		if(value<1)
			return new ResponseEntity<Calc>(HttpStatus.BAD_REQUEST);
		//if everything is ok call Calc method and return ArrayList with OK Status
		else
			return new ResponseEntity<Calc>(new Calc(value),HttpStatus.OK);
	}

}
