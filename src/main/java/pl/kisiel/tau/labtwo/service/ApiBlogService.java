package pl.kisiel.tau.labtwo.service;

public interface ApiBlogService {
    DbConnection setDataSource(DbConnection dataSource);

    DbConnection findRecordsByRegex(String regexString);
    DbConnection deleteRecords(DbConnection objectsToRemove);
}
