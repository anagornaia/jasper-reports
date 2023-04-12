package org.example.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.github.javafaker.Faker;
import java.time.LocalDate;
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
        school1.setName(faker.witcher().character());
        school1.setDescription(faker.witcher().quote());
        school1.setSearchTags(faker.witcher().location());
        school1.setPrice(15000.00);
        school1.setLocalDate(LocalDate.now());

        Item school2 = new Item();
        school2.setName(faker.witcher().character());
        school2.setDescription(faker.witcher().quote());
        school2.setSearchTags(faker.witcher().location());
        school2.setPrice(25000.00);
        school2.setLocalDate(LocalDate.now().plusDays(1));


        Item school3 = new Item();
        school3.setName(faker.witcher().character());
        school3.setDescription(faker.witcher().quote());
        school3.setSearchTags(faker.witcher().location());
        school3.setPrice(35000.00);
        school3.setLocalDate(LocalDate.now().plusDays(2));


        Item school4 = new Item();
        school4.setName(faker.witcher().character());
        school4.setDescription(faker.witcher().quote());
        school4.setSearchTags(faker.witcher().location());
        school4.setPrice(45000.00);
        school4.setLocalDate(LocalDate.now().plusDays(3));


        Item school5 = new Item();
        school5.setName(faker.witcher().character());
        school5.setDescription(faker.witcher().quote());
        school5.setSearchTags(faker.witcher().location());
        school5.setPrice(55000.00);
        school5.setLocalDate(LocalDate.now().plusDays(4));


        Item school6 = new Item();
        school6.setName(faker.witcher().character());
        school6.setDescription(faker.witcher().quote());
        school6.setSearchTags(faker.witcher().location());
        school6.setPrice(65000.00);
        school6.setLocalDate(LocalDate.now().plusDays(5));



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