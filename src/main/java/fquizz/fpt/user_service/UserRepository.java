package fquizz.fpt.user_service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByIdIn(List<Long> userIds);
}
