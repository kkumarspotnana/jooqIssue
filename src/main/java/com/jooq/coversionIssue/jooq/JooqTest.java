package com.jooq.coversionIssue.jooq;

import com.jooq.coversionIssue.jooq.codegen.tables.Testtable;
import com.jooq.coversionIssue.jooq.codegen.tables.records.TesttableRecord;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import lombok.val;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TableField;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JooqTest {

  private static String filePath="target/classes/jooq.log";
  private final Configuration jooqConfiguration;
  private final DSLContext dslContext;


  public void run(){
    clean(filePath);
    run_text();
    run_citext();
    run_varchar();
  }
  private void run_citext(){
    dump("running run_citext\n");
    test();
    testContains(Testtable.TESTTABLE.NAME_CITEXT, Testtable.TESTTABLE);
    testContainIgnoreCase(Testtable.TESTTABLE.NAME_CITEXT, Testtable.TESTTABLE);
    dump("running run_citext completed\n\n");
  }
  private void run_text(){
    dump("running run_text\n");
    test();
    testContains(Testtable.TESTTABLE.NAME_TEXT, Testtable.TESTTABLE);
    testContainIgnoreCase(Testtable.TESTTABLE.NAME_TEXT, Testtable.TESTTABLE);
    dump("running run_text completed\n\n");
  }
  private void run_varchar(){
    dump("running run_varchar\n");
    test();
    testContains(Testtable.TESTTABLE.NAME_VARCHAR, Testtable.TESTTABLE);
    testContainIgnoreCase(Testtable.TESTTABLE.NAME_VARCHAR, Testtable.TESTTABLE);
    dump("running run_varchar completed\n\n");
  }
  private void test() {
    val query=dslContext.select().from("testTable");
    dump("Query triggered : "+query.getSQL());
    val result=query.fetch();
    dump("Query result : \n"+result+"\n");
  }
  private void testContains(TableField<TesttableRecord, String> field,Testtable table) {
    val query=dslContext.select(table.fields()).from("testTable").where(field.contains(escapeLikeQueryPattern("tv")));
    dump("Query triggered : "+query.getSQL());
    val result=query.fetch();
    dump("Query result : \n"+result+"\n");
  }
  private void testContainIgnoreCase(TableField<TesttableRecord, String> field,Testtable table) {
    // This gives different result in v3.19.11 and v3.19.18 due to casting of variable issue in citext.
    // By default, citext fields on like operation gives case insensitive results, we prefer to get it handled based on Postgres Type
    // and not via containsIgnoreCase generated query, which is altogether different query
    val query=dslContext.select(table.fields()).from("testTable").where(field.containsIgnoreCase(escapeLikeQueryPattern("tv")));
    dump("Query triggered : "+query.getSQL());
    val result=query.fetch();
    dump("Query result : \n"+result+"\n");
  }
  private  String escapeLikeQueryPattern(final String query) {
    return query.replace("_", "!_").replace("%", "!%");
  }
  private void dump(String message) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
      writer.write(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void clean(final String filePath){
    Path path = Paths.get(filePath);
    try {
      Files.deleteIfExists(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
