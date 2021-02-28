package qa.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNGlisteners implements IAnnotationTransformer,IRetryAnalyzer{

	int maxcount = 1;

	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
	}

	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & maxcount < 2) {
			maxcount++;
			return true;
		}
		return false;
	}

}