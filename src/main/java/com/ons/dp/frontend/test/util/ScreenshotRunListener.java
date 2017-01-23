//package com.ons.dp.frontend.test.util;
//import org.junit.runner.Description;
//import org.junit.runner.notification.RunListener;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
///**
// * Created by admin on 20/01/2017.
// */
//public class ScreenshotRunListener extends RunListener {
//
//    protected static GifAssembler gifAssembler = new GifAssembler();
//
//    @Override
//    public void testFinished(Description description) throws Exception {
//        String details = description.getMethodName();
//        byte[] screenshot = ((TakesScreenshot) FeatureTest.driver)
//                .getScreenshotAs(OutputType.BYTES);
//        gifAssembler.addFrame(details, screenshot);
//    }
//
//}
