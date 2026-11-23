package usecases.load_profile_pictures;

public interface LoadProfilePicturesInputBoundary {
    void execute(String playerUsername, String opponentUsername);
}
