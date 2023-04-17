package service;

import model.User;

public interface UserLock {

    boolean lockUser(int id);
    boolean unlockUser(int id);
}
