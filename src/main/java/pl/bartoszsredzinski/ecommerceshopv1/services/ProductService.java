package pl.bartoszsredzinski.ecommerceshopv1.services;

import org.springframework.stereotype.Service;
import pl.bartoszsredzinski.ecommerceshopv1.model.Product;
import pl.bartoszsredzinski.ecommerceshopv1.repositoreis.ProductJpaRepository;

import java.util.List;

@Service
public class ProductService implements CrudService<Product, Integer>{

    private final ProductJpaRepository repository;

    public ProductService(ProductJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product object){
        return repository.save(object);
    }

    @Override
    public void delete(Product object){
        repository.delete(object);
    }

    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
