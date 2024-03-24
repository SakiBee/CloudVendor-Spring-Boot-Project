package com.sakibee.restproject.service.implementation;

import com.sakibee.restproject.exception.CloudVendorNotFoundException;
import com.sakibee.restproject.model.CloudVendor;
import com.sakibee.restproject.repository.CloudVendorRepository;
import com.sakibee.restproject.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor Doesn't Exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
