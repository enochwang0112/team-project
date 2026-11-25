package usecases.api_interfaces;

import java.awt.*;
import entities.UserProfile;

public interface IUserProfileRepo {
    Image getProfilePicture(String username);
    UserProfile getUserProfile(String username);
}
