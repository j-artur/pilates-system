package dev.jartur.pilates_system.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(long id) {
    return userRepository.findById(id);
  }

  public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(long id, User user) {
    User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());
    return userRepository.save(existingUser);
  }

  public void deleteUser(long id) {
    userRepository.deleteById(id);
  }
}
