import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestLogger implements TestWatcher {

    Log4j log4j = new Log4j();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log4j.info(testName + " BAŞARILI");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        log4j.warn(testName + " İPTAL EDİLDİ! İptal sebebi : " +testFailCause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        log4j.error(testName + " HATA! Hata açıklaması : " +testFailCause);
    }

}
