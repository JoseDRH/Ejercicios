package com.example.block13criteriabuilder.Application.Person.Crud;

import com.example.block13criteriabuilder.Application.Exceptions.EntityNotFoundException;
import com.example.block13criteriabuilder.Application.Person.Model.PersonDTO;
import com.example.block13criteriabuilder.Application.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServicePerson  {

    @Autowired
    RepositoryPerson repositoryPerson;
    @PersistenceContext
    EntityManager em;

    public List<PersonDTO> finPersonbyFilters(String name, String user, String surname, String dateLe, String dateGre, String order) throws ParseException {

        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Person> query=cb.createQuery(Person.class);
        Root<Person> root= query.from(Person.class);
        List<Predicate> predicates =new ArrayList<>();
        if(name!=null){
            predicates.add(cb.like(root.get("name"),
                    ("%"+name+"%")));
        }
        if(user!=null){
            predicates.add(cb.like(root.get("usuario"),
                    ("%"+user+"%" )));
        }
        if(surname!=null){
            predicates.add(cb.like(root.get("surname"),
                    ("%"+surname+"%")));
        }
        if (dateLe!=null){
            predicates.add(cb.lessThan(root.get("created_date"),new SimpleDateFormat("dd/MM/yyyy").parse(dateLe)));

        }
        else if(dateGre!=null){
            predicates.add(cb.greaterThan(root.get("created_date"),new SimpleDateFormat("dd/MM/yyyy").parse(dateGre)));
        }
        if (order!=null){
            if (order.equals("name")){
                query.orderBy(cb.desc(root.get("name")));
            }
            else if (order.equals("user")){
                query.orderBy(cb.asc(root.get("usuario")));
            }
        }
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        List<PersonDTO> list= em.createQuery(query).getResultList().stream().map(Person::setToDTO).toList();
        return  list;
    }

    public List<PersonDTO> finPersonbyFiltersandPage(String name, String user, String surname, String dateLe, String dateGre, String order,int pageNumber) throws ParseException {
        int pageSize=10;


        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Person> query=cb.createQuery(Person.class);
        Root<Person> root= query.from(Person.class);
        List<Predicate> predicates =new ArrayList<>();
        if(name!=null){
            predicates.add(cb.like(root.get("name"),
                    ("%"+name+"%")));
        }
        if(user!=null){
            predicates.add(cb.like(root.get("usuario"),
                    ("%"+user+"%" )));
        }
        if(surname!=null){
            predicates.add(cb.like(root.get("surname"),
                    ("%"+surname+"%")));
        }
        if (dateLe!=null){
            predicates.add(cb.lessThan(root.get("created_date"),new SimpleDateFormat("dd/MM/yyyy").parse(dateLe)));

        }
        else if(dateGre!=null){
            predicates.add(cb.greaterThan(root.get("created_date"),new SimpleDateFormat("dd/MM/yyyy").parse(dateGre)));
        }
        if (order!=null){
            if (order.equals("name")){
                query.orderBy(cb.desc(root.get("name")));
            }
            else if (order.equals("user")){
                query.orderBy(cb.asc(root.get("usuario")));
            }
        }
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        List<PersonDTO> list= em.createQuery(query).getResultList().stream().map(Person::setToDTO).toList();
        PagedListHolder<PersonDTO> page = new PagedListHolder<>(list);
        page.setPageSize(pageSize);
        page.setPage(pageNumber);
        return page.getPageList();
    }
    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<>();
        repositoryPerson.findAll().forEach(person -> people.add(person));
        return people;
    }
    public Person getPersonById(Integer id) throws EntityNotFoundException {
            if(repositoryPerson.findById(id).isEmpty()) {
                throw  new EntityNotFoundException();
            }
            else return  repositoryPerson.findById(id).get();
    }
    public void savePerson(Person person){
        repositoryPerson.save(person);
    }
    public void deletePerson(Integer id) throws EntityNotFoundException {
        if(repositoryPerson.findById(id).isEmpty()) {
            throw  new EntityNotFoundException();
        }
        else repositoryPerson.deleteById(id);
    }
}
