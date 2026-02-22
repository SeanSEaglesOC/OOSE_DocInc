package docinc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DeliveryPreferenceServiceTest {

    // --- STUB ---
    // A stub returns a fixed value for the fee policy.
    static class StubFeePolicy implements FeePolicy {
        @Override
        public double paperStatementFee() {
            return 2.00;
        }
    }

    // --- DUMMY notification implementation for non-mock tests ---
    static class DummyNotificationGateway implements NotificationGateway {
        @Override
        public void sendPreferenceChangeNotice(String email, String message) {
            // do nothing
        }
    }

    @Test
    void changePreference_toPaper_appliesFeeAnd7DayDelay_usingStub() {
        // Stub used here
        FeePolicy feePolicy = new StubFeePolicy();
        NotificationGateway dummyGateway = new DummyNotificationGateway();
        DeliveryPreferenceService service = new DeliveryPreferenceService(feePolicy, dummyGateway);

        LocalDate requestDate = LocalDate.of(2026, 2, 22);

        DeliveryPreferenceService.PreferenceChangeResult result =
                service.changePreference("john@example.com", "PAPER", requestDate);

        assertEquals("PAPER", result.getMethod());
        assertTrue(result.isPaperFeeEnabled());
        assertEquals(2.00, result.getFee(), 0.001);
        assertEquals(LocalDate.of(2026, 3, 1), result.getEffectiveDate()); // +7 days
    }

    @Test
    void changePreference_toEmail_hasNoFeeAnd7DayDelay() {
        FeePolicy feePolicy = new StubFeePolicy();
        NotificationGateway dummyGateway = new DummyNotificationGateway();
        DeliveryPreferenceService service = new DeliveryPreferenceService(feePolicy, dummyGateway);

        LocalDate requestDate = LocalDate.of(2026, 2, 22);

        DeliveryPreferenceService.PreferenceChangeResult result =
                service.changePreference("john@example.com", "EMAIL", requestDate);

        assertEquals("EMAIL", result.getMethod());
        assertFalse(result.isPaperFeeEnabled());
        assertEquals(0.0, result.getFee(), 0.001);
        assertEquals(LocalDate.of(2026, 3, 1), result.getEffectiveDate());
    }

    @Test
    void changePreference_invalidMethod_throwsException() {
        FeePolicy feePolicy = new StubFeePolicy();
        NotificationGateway dummyGateway = new DummyNotificationGateway();
        DeliveryPreferenceService service = new DeliveryPreferenceService(feePolicy, dummyGateway);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                service.changePreference("john@example.com", "FAX", LocalDate.of(2026, 2, 22)));

        assertTrue(ex.getMessage().contains("EMAIL or PAPER"));
    }

    @Test
    void changePreference_sendsNotification_usingMock() {
        FeePolicy feePolicy = new StubFeePolicy();

        // Mock used here
        NotificationGateway mockGateway = mock(NotificationGateway.class);

        DeliveryPreferenceService service = new DeliveryPreferenceService(feePolicy, mockGateway);

        service.changePreference("john@example.com", "PAPER", LocalDate.of(2026, 2, 22));

        verify(mockGateway, times(1))
                .sendPreferenceChangeNotice(eq("john@example.com"), contains("PAPER"));
    }
}