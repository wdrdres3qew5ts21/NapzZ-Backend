package com.napzz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.Image;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.location.Location;
import com.napzz.entity.review.Review;
import com.napzz.entity.room.ContractType;
import com.napzz.entity.room.Room;
import com.napzz.repository.ContractTypeRepository;
import com.napzz.repository.FacilityFeatureRepository;
import com.napzz.repository.LandmarkFeatureRepository;
import com.napzz.repository.RoomRepository;

@ApplicationScoped
public class RoomService {

    @Inject
    private RoomRepository roomRepository;

    @Inject
    private LandmarkFeatureRepository landmarkFeatureRepository;

    @Inject 
    private FacilityFeatureRepository facilityFeatureRepository;

    @Inject 
    private ContractTypeRepository contractTypeRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> findRoomById(int roomId) {
        return roomRepository.findById(roomId);
    }

    public List<Room> listRoom() {
        return roomRepository.findAll();
    }

    public FacilityFeature createFacilityFeature(FacilityFeature facilityFeature) {
        FacilityFeature createdFacilityFeature = facilityFeatureRepository.save(facilityFeature);
        return createdFacilityFeature;

    }

    public LandmarkFeature createLandmarkFeature(LandmarkFeature landmarkFeature) {
        return landmarkFeatureRepository.save(landmarkFeature);
    }

    public Room init() {
        ContractType monthlyContract = new ContractType(1, "monthly");
        ContractType yearlyContract = new ContractType(2, "yearly");
        contractTypeRepository.save(monthlyContract);
        contractTypeRepository.save(yearlyContract);

        LandmarkFeature landmarkFeature1 = new LandmarkFeature(1,"บริการขนส่งสาธารณะในระยะ 400 เมตร");
        LandmarkFeature landmarkFeature2 = new LandmarkFeature(2,"Wifi Free Whole Apartment");
        LandmarkFeature landmarkFeature3 = new LandmarkFeature(3,"Gym Maxxing");
        landmarkFeatureRepository.save(landmarkFeature1);
        landmarkFeatureRepository.save(landmarkFeature2);
        landmarkFeatureRepository.save(landmarkFeature3);

        FacilityFeature facilityFeature1 = new FacilityFeature(1, "Two Bed");
        FacilityFeature facilityFeature2 = new FacilityFeature(2, "Elagant Vantage");
        FacilityFeature facilityFeature3 = new FacilityFeature(3, "No Smoking");
        FacilityFeature facilityFeature4 = new FacilityFeature(4, "Air Conditioning");
        facilityFeatureRepository.save(facilityFeature1);
        facilityFeatureRepository.save(facilityFeature2);
        facilityFeatureRepository.save(facilityFeature3);
        facilityFeatureRepository.save(facilityFeature4);

        String description1 = "Drawing its design theme from the classic Sino-Portuguese architecture that characterises Phuket Town, Centara Grand Beach Resort Phuket is set directly on the sands at Karon Beach, backed by a green hill, and grouped around its own water park.  The resort offers a memorable holiday experience for everyone: couples and families will love the exhilarating leisure activities, the water sports, and of course the water park, and corporate and incentive groups have fine meeting facilities.";
        ArrayList<Image> imageList1= new ArrayList();
        imageList1.add(new Image(1,"https://pix6.agoda.net/hotelImages/6024613/-1/0443725487752c48ab6761a3d659d816.jpg?s=1024x768"));
        imageList1.add(new Image(2,"https://img.travel.rakuten.co.jp/share/image_up/172054/LARGE/7b1080a5373288e22c687ae72d033d899e18f4c8.47.1.26.2.jpg"));
        ContractType contractRoom1 = new ContractType();
        contractRoom1.setContractId(1);
        List<LandmarkFeature> landmarkRoom1 = new ArrayList<>();
        landmarkRoom1.add(landmarkFeature1);
        landmarkRoom1.add(landmarkFeature2);
        landmarkRoom1.add(landmarkFeature3);

        List<FacilityFeature> facilityRoom1 = new ArrayList<>();
        facilityRoom1.add(facilityFeature1);
        facilityRoom1.add(facilityFeature2);
        facilityRoom1.add(facilityFeature3);
        facilityRoom1.add(facilityFeature4);

        List<Review> reviews= new ArrayList<Review>();
        String comment1="This was our first place to stay in Phuket and we loved it! The bed was very comfortable, the washing machine was free and the drier only 100 BAht. We could leave our luggage after check-out, so we could spend the day in the city before going to our next city";
        reviews.add(new Review(1, 4.5,"Clarrisa Claudia",comment1));
        String comment2="หอพักที่ให้ค่าถึงจิตวิญญาณของท่านผ่านฟ้า ใครที่ต้องการจะมาฝึกค่ายมวยธวัชล้ำฟ้า ต้องไม่พลาดหอพักที่นี่ ซึ่งใกล้กับสนามมวยอันเลื่องชื่อมากที่สุด";
        reviews.add(new Review(2, 4.5,"ฟ้าคำราม ซื่อตรง",comment2));

        Location location= new Location("Phuket","30 หมู่ 3 ซ.ราชอุทิศ 1 ถ.ราชอุทิศ200ปี ต.ป่าตอง อ.กระทู้ จ.ภูเก็ต 83150");

        Room room1 = new Room(1,"หอธวัชล้ำฟ้า Phuket", description1,imageList1,2500,contractRoom1,landmarkRoom1,facilityRoom1,reviews,location);
        roomRepository.save(room1);
        
        System.out.println("===================");
        System.out.println(room1);
        return room1;
    }

    public void deleteRoomById(int roomId) {
        HashMap<String, String> response = new HashMap();
        response.put("message", "Delete Successfull");
        roomRepository.deleteById(roomId);
    }

    public ContractType createContractType(ContractType contract) {
        ContractType savedContractType = contractTypeRepository.save(contract);
        return  savedContractType;
    }
    
}
