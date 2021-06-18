package com4j.tlbimp.driver;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.springframework.scheduling.config.Task;


import com4j.ComException;
import com4j.GUID;
import com4j.tlbimp.BindingException;
import com4j.tlbimp.ErrorListener;
import com4j.tlbimp.FileCodeWriter;
import com4j.tlbimp.def.IWTypeLib;
import java.util.logging.Logger;
/**
 * tlbimp implemented as an Ant task.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class AntTaskImpl extends Task implements ErrorListener {
	
	public AntTaskImpl(Runnable runnable) {
		super(runnable);
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = Logger.getLogger("AntTaskImpl.class");
	private File destDir;
    private File source;

    private GUID libid;
    private String libver;

    private Driver driver = new Driver();

    private boolean hasLib = false;

    public void setDestDir(File destDir) {
        this.destDir = destDir;
    }

    public void setPackage(String packageName) {
        driver.setPackageName(packageName);
    }

    public void setFile(File source) {
        this.source = source;
    }

    public void setLibid(String libid) {
        this.libid = new GUID(libid);
    }

    public void setLibver(String libver) {
        this.libver = libver;
    }

    public void setLocale(String locale) {
        driver.setLocale(locale);
    }

    public void setRenameGetterAndSetters(boolean renameGetterAndSetters) {
        driver.renameGetterAndSetters = renameGetterAndSetters;
    }

    public void setAlwaysUseComEnums(boolean alwaysUseComEnums) {
        driver.alwaysUseComEnums = alwaysUseComEnums;
    }

    public void setGenerateDefaultMethodOverloads(boolean v) {
        driver.generateDefaultMethodOverloads = v;
    }

    public void addConfiguredLib( Lib r ) {
        r.validate();
        driver.addLib(r);
        hasLib = true;
    }

    public void execute() throws BuildException {
        if( destDir==null )
            throw new BuildException("@destDir is missing");

        if(source!=null || libid!=null) {
            Lib lib = new Lib();
            lib.setLibid(libid);
            lib.setLibver(libver);
            lib.setFile(source);
            addConfiguredLib(lib);
        }

        if(!hasLib)
            throw new BuildException("No type library is specified");

        try {
            driver.run( new FileCodeWriter(destDir), this);
        } catch( ComException e ) {
            throw new BuildException(e);
        } catch( IOException e ) {
            throw new BuildException(e);
        } catch( BindingException e ) {
            throw new BuildException(e);
        }
    }

    public void started(IWTypeLib lib) {
    //	String msg_info = Project.MSG_INFO;
    	logger.info("Generating definitions from "+lib.getName().toString());
    }

    public void error(BindingException e) {
    	//Project.MSG_ERR
    	logger.info(e.getMessage());
    }

    public void warning(String message) {
    //	log(message,Project.MSG_WARN);
    	logger.info(message);
    }
}
