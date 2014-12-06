package org.example.issuetracker.service;

import org.example.issuetracker.model.Issue;
import org.example.issuetracker.model.IssuePriority;
import org.example.issuetracker.model.IssueStatus;
import org.example.issuetracker.repository.IssueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceBean implements IssueService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Iterable<Issue> findAll() {
        logger.info("> findAll");

        Iterable<Issue> issues = issueRepository.findAll();

        logger.info("< findAll");
        return issues;
    }

    @Override
    public Issue find(String id) {
        logger.info("> find id:{}", id);

        Issue issue = issueRepository.findOne(id);

        logger.info("< find id:{}", id);
        return issue;
    }

    @Override
    public Issue create(Issue issue) {
        logger.info("> create");

        // Set default attribute values
        issue.setStatus(IssueStatus.OPEN);

        if (issue.getPriority() == null) {
            issue.setPriority(IssuePriority.MEDIUM);
        }

        Issue i = issueRepository.save(issue);

        logger.info("< create");
        return i;
    }

    @Override
    public Issue update(Issue issue) {
        logger.info("> update");

        Issue i = issueRepository.save(issue);

        logger.info("< update");
        return i;
    }

    @Override
    public void delete(String id) {
        logger.info("> delete");

        issueRepository.delete(id);

        logger.info("< delete");
    }

}