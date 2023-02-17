package repository;

import entity.AppRole;
import entity.AppUser;
import entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser (AppUser appUser);
}
