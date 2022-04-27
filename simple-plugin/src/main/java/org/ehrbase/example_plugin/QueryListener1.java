package org.ehrbase.example_plugin;

import java.util.function.Function;
import org.ehrbase.plugin.dto.QueryWithParameters;
import org.ehrbase.plugin.extensionpoints.AbstractQueryExtensionPoint;
import org.ehrbase.response.ehrscape.QueryResultDto;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
public class QueryListener1 extends AbstractQueryExtensionPoint {
  private static final Logger log = LoggerFactory.getLogger(QueryListener1.class);

  @Override
  public QueryWithParameters beforeQueryExecution(QueryWithParameters input) {
    log.info("Before Query Exec QueryListener1");
    return super.beforeQueryExecution(input);
  }

  @Override
  public QueryResultDto afterQueryExecution(QueryResultDto output) {
    log.info("After Query Exec QueryListener1");
    return super.afterQueryExecution(output);
  }

  @Override
  public QueryResultDto aroundQueryExecution(QueryWithParameters input, Function<QueryWithParameters, QueryResultDto> chain) {
    log.info("Around Query Exec start QueryListener1");
    QueryResultDto queryResultDto = super.aroundQueryExecution(input, chain);
    log.info("Around Query Exec end QueryListener1");
    return queryResultDto;
  }
}
