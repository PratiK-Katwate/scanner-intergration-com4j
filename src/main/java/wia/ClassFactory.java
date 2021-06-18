package wia  ;

import com4j.*;

/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactory {
  private ClassFactory() {} // instanciation is not allowed


  /**
   * The Rational object is a container for the rational values found in Exif tags. It is a supported element type of the Vector object and may be created using "WIA.Rational" in a call to CreateObject.
   */
  public static wia.IRational createRational() {
    return COM4J.createInstance( wia.IRational.class, "{0C5672F9-3EDC-4B24-95B5-A6C54C0B79AD}" );
  }

  /**
   * The Vector object is a collection of values of the same type. It is used throughout the library in many different ways. The Vector object may be created using "WIA.Vector" in a call to CreateObject.
   */
  public static wia.IVector createVector() {
    return COM4J.createInstance( wia.IVector.class, "{4DD1D1C3-B36A-4EB4-AAEF-815891A58A30}" );
  }

  /**
   * The ImageFile object is a container for images transferred to your computer when you call Transfer or ShowTransfer. It also supports image files through LoadFile. An ImageFile object can be created using "WIA.ImageFile" in a call to CreateObject.
   */
  public static wia.IImageFile createImageFile() {
    return COM4J.createInstance( wia.IImageFile.class, "{A2E6DDA0-06EF-4DF3-B7BD-5AA224BB06E8}" );
  }

  /**
   * The ImageProcess object manages the filter chain. An ImageProcess object can be created using "WIA.ImageProcess" in a call to CreateObject.
   */
  public static wia.IImageProcess createImageProcess() {
    return COM4J.createInstance( wia.IImageProcess.class, "{BD0D38E4-74C8-4904-9B5A-269F8E9994E9}" );
  }

  /**
   * The CommonDialog control is an invisible-at-runtime control that contains all the methods that display a User Interface. A CommonDialog control can be created using "WIA.CommonDialog" in a call to CreateObject or by dropping a CommonDialog on a form.
   */
  public static wia.ICommonDialog createCommonDialog() {
    return COM4J.createInstance( wia.ICommonDialog.class, "{850D1D11-70F3-4BE5-9A11-77AA6B2BB201}" );
  }

  /**
   * The DeviceManager control is an invisible-at-runtime control that manages the imaging devices connected to the computer. A DeviceManager control can be created using "WIA.DeviceManager" in a call to CreateObject or by dropping a DeviceManager on a form.
   */
  public static wia.IDeviceManager createDeviceManager() {
    return COM4J.createInstance( wia.IDeviceManager.class, "{E1C5D730-7E97-4D8A-9E42-BBAE87C2059F}" );
  }
}
