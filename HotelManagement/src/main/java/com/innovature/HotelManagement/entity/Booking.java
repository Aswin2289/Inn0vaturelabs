package com.innovature.HotelManagement.entity;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innovature.HotelManagement.form.BookingForm;
@Entity
public class Booking {
    public static enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name =  "hotel_id", referencedColumnName = "hotel_id")
    private Hotel hotelId;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name =  "type_id", referencedColumnName = "type_id")
    private HotelRoom typeId;
    private byte status;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;


    

    public Booking(){

    }

    public Booking(Integer bookId){

    }

    public Booking(BookingForm form,Integer userId,Hotel hotel,HotelRoom hotelRoom){
        this.user=new User(userId);
        this.bookName=form.getBookName();
        // this.hotelId= new Hotel(form.getHotelId());
        // this.typeId=new HotelRoom(form.getTypeId());
        this.hotelId=hotel;
        this.typeId=hotelRoom;
        this.startDate=form.getStartDate();
        this.endDate=form.getEndDate();
        this.status = Status.ACTIVE.value;
        Date dt = new Date();
        this.createDate = dt;

    }






    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        bookName = bookName;
    }
   
    
    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public HotelRoom getTypeId() {
        return typeId;
    }

    public void setTypeId(HotelRoom typeId) {
        this.typeId = typeId;
    }

    public byte getStatus() {
        return status;
    }
    public void setStatus(byte status) {
        this.status = status;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    
}
