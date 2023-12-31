package ss13_search.service.impl;

import ss13_search.model.Job;
import ss13_search.repository.IJobRepository;
import ss13_search.repository.impl.JobRepository;
import ss13_search.service.IJobService;
import ss13_search.utils.CsvFile;
import ss13_search.utils.IdNotFoundException;
import ss13_search.utils.UniqueIDException;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobService implements IJobService {
    private static IJobRepository jobRepository = new JobRepository();

    @Override
    public List<Job> getAll(){
        return jobRepository.getAll();
    }

    @Override
    public boolean checkCode(String code){
        return jobRepository.checkCode(code);
    }

    @Override
    public void addJob(Job job){
        jobRepository.addJob(job);
    }

    @Override
    public void removeJob(String code){
        jobRepository.removeJob(code);
    }

    @Override
    public void editJob(String code, Job job){
        jobRepository.editJob(code, job);
    }

    @Override
    public Job findByCode(String code){
        return jobRepository.findByCode(code);
    }

    @Override
    public List<Job> findByName(String name){
        return jobRepository.findByName(name);
    }

    @Override
    public List<Job> sortByName(){
        List<Job> jobList = jobRepository.getAll();
        jobList.sort(Comparator.comparing(Job::getName));
        return jobList;
    }

    @Override
    public List<Job> sortByMoney(){
        List<Job> jobList = jobRepository.getAll();
        jobList.sort(Comparator.comparing(Job::getMoney).reversed().thenComparing(Job::getName));
        return jobList;
    }
}
