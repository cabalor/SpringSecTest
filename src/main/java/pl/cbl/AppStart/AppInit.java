package pl.cbl.AppStart;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import pl.cbl.security.SecuCfg;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecuCfg.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConf.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
