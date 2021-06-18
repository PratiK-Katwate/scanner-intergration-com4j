package io.mosip.scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import wia.ClassFactory;
import wia.ICommonDialog;
import wia.WiaDeviceType;
import wia.WiaImageBias;
import wia.WiaImageIntent;

@SpringBootApplication
public class ScannerIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerIntegrationApplication.class, args);
		
		System.out.println("Integrating Scanner with Windows 10");
		
		ICommonDialog wiaObj = ClassFactory.createCommonDialog();
		wiaObj.showAcquireImage(WiaDeviceType.ScannerDeviceType, WiaImageIntent.ColorIntent,
				WiaImageBias.MaximizeQuality, "", false, false, false);
	}
	
}
