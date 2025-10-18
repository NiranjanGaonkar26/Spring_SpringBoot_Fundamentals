package com.ngc.Ex17_Lec128.Repository;

import com.ngc.Ex17_Lec128.Constants.ApplicationConstants;
import com.ngc.Ex17_Lec128.Model.Contact;
import com.ngc.Ex17_Lec128.RowMappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveMessageToDB(Contact contact){
        String insertSql = "INSERT INTO contact_msg (name,mobile_num,email,subject,message,status,created_at,created_by) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(insertSql, contact.getName(), contact.getMobileNum(), contact.getEmail(), contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(), contact.getCreatedBy());
    }

    public List<Contact> fetchMsgsWithStatus(String status) {

        String sql = "SELECT * FROM contact_msg WHERE status = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        }, new ContactRowMapper());
    }

    public int closeOpenMessageStatus(int msgid, String updatedBy) {
        String updateSql = "UPDATE contact_msg SET status = ?, updated_by = ?, updated_at = ? WHERE contact_id = ?";
        return jdbcTemplate.update(updateSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, ApplicationConstants.CLOSE);
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, msgid);
            }
        });
    }
}
