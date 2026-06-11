package com.azharx.companyservice.company;

import java.util.List;

public interface CompanyService {

   List<Company> getAllComanies();

   boolean updateCompany(Long id, Company company);

   void createCompany(Company company);

   boolean deleteCompanyById(Long id);

   Company getCompanyById(Long id);
}
