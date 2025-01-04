package kz.petproject.service.impl;

import kz.petproject.dao.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainServiceImplTest {
    @Autowired
    private AppUserDAO appUserDAO;

//    @Test
//    public void testSaveRawData() {
//        Update update = new Update();
//        Message msg = new Message();
//        msg.setText("ololo");
//        update.setMessage(msg);
//
//        RawData rawData = RawData.builder()
//                .event(update)
//                .build();
//        Set<RawData> testData = new HashSet<>();
//
//        testData.add(rawData);
//        rawDataDAO.save(rawData);
//
//        Assert.isTrue(testData.contains(rawData), "Entity is not found in the set");
//    }
}