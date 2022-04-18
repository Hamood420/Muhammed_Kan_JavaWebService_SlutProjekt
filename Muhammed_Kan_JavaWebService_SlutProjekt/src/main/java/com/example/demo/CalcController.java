package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/calc")
public class CalcController {

		private CalculatorService cs = new CalculatorService();
		

			@RequestMapping(value = "/add",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public String add(@RequestParam Double number1, @RequestParam Double number2) {
		        return "{" +
				"\"Result\":" + "\"" + cs.add(number1, number2) + "\""+ 
				"}";
		    }

		    @RequestMapping(value ="/sub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public String sub(@RequestParam Double number1, @RequestParam Double number2) {
		        return "{" +
						"\"Result\":" + "\"" + cs.sub(number1, number2) + "\""+ 
						"}";
		    }

		    @RequestMapping(value ="/multi",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public String multi(@RequestParam Double number1, @RequestParam Double number2) {
		        return "{" +
						"\"Result\":" + "\"" + cs.multi(number1, number2) + "\""+ 
						"}";
		    }

		    @RequestMapping(value ="/div",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public String div(@RequestParam Double number1, @RequestParam Double number2) {
		        return "{" +
						"\"Result\":" + "\"" + cs.add(number1, number2) + "\""+ 
						"}";
		    }
		    

	}