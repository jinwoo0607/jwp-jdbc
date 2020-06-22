package core.jdbc.callback;

import core.jdbc.argumentsetter.PreparedStatementSetter;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class UpdateStatementCallback extends AbstractStatementCallback<Integer> {
    public UpdateStatementCallback(String sql) {
        super(sql, null);
    }

    public UpdateStatementCallback(String sql, PreparedStatementSetter pss) {
        super(sql, pss);
    }

    @Override
    public Integer executeStatement(PreparedStatement ps) throws SQLException {
        setPreparedStatementValues(ps);

        int updatedCount = ps.executeUpdate();
        log.debug("SQL update count: {}", updatedCount);
        return updatedCount;
    }
}
