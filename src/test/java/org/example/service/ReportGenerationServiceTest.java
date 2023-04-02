package org.example.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.example.domain.Item;
import org.example.domain.ReportProfile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReportGenerationServiceTest {

    ReportGenerationService reportGenerationService = new ReportGenerationService();

    @ParameterizedTest
    @MethodSource("provideListOfItems")
    void printReport(List<Item> items) {
        assertDoesNotThrow(() -> reportGenerationService.printReport(items));
    }

    @ParameterizedTest
    @MethodSource("provideListOfItemsAndReportProfile")
    void printReport(List<Item> items, ReportProfile reportProfile) {
        assertDoesNotThrow(() -> reportGenerationService.printReport(items, reportProfile));
    }

    private static Stream<Arguments> provideListOfItemsAndReportProfile() {
        return Stream.of(
            Arguments.of(getItemList(), getReportProfile())
        );
    }

    private static ReportProfile getReportProfile() {
        ReportProfile reportProfile = new ReportProfile();
        reportProfile.setIsShowName(Boolean.FALSE);
        reportProfile.setIsShowPrice(Boolean.TRUE);
        reportProfile.setIsShowDescription(Boolean.TRUE);
        reportProfile.setIsShowSearchTags(Boolean.TRUE);
        return reportProfile;
    }


    private static Stream<Arguments> provideListOfItems() {
        return Stream.of(
            Arguments.of(getItemList())
        );
    }

    private static List<Item> getItemList() {
        Faker faker = new Faker();
        /* List to hold Items */
        List<Item> witcher = new ArrayList<Item>();

        /* Create Items */
        Item school1 = new Item();
        school1.setName(faker.lorem().characters(5, 20));
        school1.setDescription(faker.lorem().characters(10, 70));
        school1.setSearchTags(faker.lorem().characters(10, 40));
        school1.setPrice(15000.00);

        Item school2 = new Item();
        school2.setName(faker.lorem().characters(5, 20));
        school2.setDescription(faker.lorem().characters(10, 1000));
        school2.setSearchTags(faker.lorem().characters(10, 40));
        school2.setPrice(25000.00);

        Item school3 = new Item();
        school3.setName(faker.lorem().characters(5, 20));
        school3.setDescription(faker.lorem().characters(10, 60));
        school3.setSearchTags(faker.lorem().characters(10, 40));
        school3.setPrice(35000.00);

        Item school4 = new Item();
        school4.setName(faker.lorem().characters(5, 20));
        school4.setDescription(faker.lorem().characters(10, 50));
        school4.setSearchTags(faker.lorem().characters(10, 40));
        school4.setPrice(45000.00);

        Item school5 = new Item();
        school5.setName(faker.lorem().characters(5, 20));
        school5.setDescription(faker.lorem().characters(10, 50));
        school5.setSearchTags(faker.lorem().characters(10, 40));
        school5.setPrice(55000.00);

        Item school6 = new Item();
        school6.setName(faker.lorem().characters(5, 20));
        school6.setDescription(faker.lorem().characters(10, 50));
        school6.setSearchTags(faker.lorem().characters(10, 40));
        school6.setPrice(65000.00);


        /* Add Items to List */
        witcher.add(school1);
        witcher.add(school2);
        witcher.add(school3);
        witcher.add(school4);
        witcher.add(school5);
        witcher.add(school6);
        return witcher;
    }
}