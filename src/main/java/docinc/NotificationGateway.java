package docinc;

public interface NotificationGateway {
    void sendPreferenceChangeNotice(String email, String message);
}