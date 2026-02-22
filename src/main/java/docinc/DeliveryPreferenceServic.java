package docinc;

import java.time.LocalDate;
import java.util.Objects;

public class DeliveryPreferenceService {

    private final FeePolicy feePolicy;
    private final NotificationGateway notificationGateway;

    public DeliveryPreferenceService(FeePolicy feePolicy, NotificationGateway notificationGateway) {
        this.feePolicy = Objects.requireNonNull(feePolicy);
        this.notificationGateway = Objects.requireNonNull(notificationGateway);
    }

    public PreferenceChangeResult changePreference(String email, String method, LocalDate requestDate) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!"EMAIL".equalsIgnoreCase(method) && !"PAPER".equalsIgnoreCase(method)) {
            throw new IllegalArgumentException("Method must be EMAIL or PAPER");
        }

        String normalizedMethod = method.toUpperCase();
        LocalDate effectiveDate = requestDate.plusDays(7);
        boolean paperFeeEnabled = "PAPER".equals(normalizedMethod);
        double fee = paperFeeEnabled ? feePolicy.paperStatementFee() : 0.0;

        String message = "Preference updated to " + normalizedMethod
                + ". Effective on " + effectiveDate
                + (paperFeeEnabled ? ". $2 paper fee applies." : ". No paper fee.");

        notificationGateway.sendPreferenceChangeNotice(email, message);

        return new PreferenceChangeResult(normalizedMethod, effectiveDate, paperFeeEnabled, fee);
    }

    public static class PreferenceChangeResult {
        private final String method;
        private final LocalDate effectiveDate;
        private final boolean paperFeeEnabled;
        private final double fee;

        public PreferenceChangeResult(String method, LocalDate effectiveDate, boolean paperFeeEnabled, double fee) {
            this.method = method;
            this.effectiveDate = effectiveDate;
            this.paperFeeEnabled = paperFeeEnabled;
            this.fee = fee;
        }

        public String getMethod() {
            return method;
        }

        public LocalDate getEffectiveDate() {
            return effectiveDate;
        }

        public boolean isPaperFeeEnabled() {
            return paperFeeEnabled;
        }

        public double getFee() {
            return fee;
        }
    }
}