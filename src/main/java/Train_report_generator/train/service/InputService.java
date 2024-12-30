package Train_report_generator.train.service;


import Train_report_generator.train.entity.Input;
import Train_report_generator.train.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    @Autowired
    private InputRepository inputRepo;

public Input saveInputData(Input input){
     return    this.inputRepo.save(input);
    }
}