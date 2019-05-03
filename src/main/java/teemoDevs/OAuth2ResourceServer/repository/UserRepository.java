package teemoDevs.OAuth2ResourceServer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import teemoDevs.OAuth2ResourceServer.auth.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
