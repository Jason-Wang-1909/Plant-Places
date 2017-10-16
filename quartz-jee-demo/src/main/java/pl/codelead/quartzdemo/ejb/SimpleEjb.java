package pl.codelead.quartzdemo.ejb;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SimpleEjb {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleEjb.class);
	
	public void doSomething() {
		LOG.info("Inside an EJB");
	}
}