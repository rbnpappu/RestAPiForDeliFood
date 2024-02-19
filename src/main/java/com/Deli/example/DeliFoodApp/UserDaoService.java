package com.Deli.example.DeliFoodApp;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;



@Component
public class UserDaoService {

    @Autowired
    private userDaoDataJPA userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }
    
//    public Optional<Users> update( Long id, Users user) {
//        // Only update an item if it can be found first.
//        return userRepository.findById(id)
//                .map(oldItem -> {
//                   Users updated = oldItem.updateWith(user);
//                   return userRepository.save(updated);
//                });
//    }
    public Users findById(int id) {
        Optional<Users> optionalUser = userRepository.findById((long)id);
        return optionalUser.orElse(null);
    }

    public Users save(Users user) {
    	
        // Save the user using the JPA repository
        return userRepository.save(user);
    }
    
    @Transactional
    public Users update(int id, Users user) {
        // Check if the user with the given id exists before attempting to delete
        if (userRepository.existsById((long) id)) {
            userRepository.deleteById((long) id);

            // Save the user using the JPA repository
            return userRepository.save(user);
        } else {
            // Handle the case where the user with the given id does not exist
            // You can throw an exception, log a message, or handle it as appropriate for your application
            return null;
        }
    }

    
    public void deleteById(int id) {
    	 userRepository.deleteById((long)id);
    }

}
