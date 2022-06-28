package spring.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.models.AdminModel;
import spring.demo.repository.AdminRepository;
@Service
public class AdminService {
    @Autowired 
    private AdminRepository adminRepository;
    
    public List<AdminModel> getAdmins(){
        return (List<AdminModel>) adminRepository.findAll();
    }
    
    public AdminModel guardarAdmin(AdminModel admin){
        return adminRepository.save(admin);
    }
}
