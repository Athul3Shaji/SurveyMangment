import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
// import { MatCard } from '@angular/material/card';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  url! : any
  image =JSON.parse(sessionStorage.getItem("usermail")|| '{}')

  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/get/image/info/' + this.image)
    .subscribe(
      res => {
        this.postResponse = res;
        this.dbImage = 'data:image/jpeg;base64,' + this.postResponse.image;
      }
    );
  }
  onSelectFile(event:any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.url = event
      }
    }
  }
  uploadedImage!: File;
  dbImage: any;
  postResponse: any;
  successResponse!: string;
  

  public onImageUpload(event:any) {
    this.uploadedImage = event.target.files[0];
  }


  imageUploadAction() {
    const imageFormData = new FormData();
    imageFormData.append('image', this.uploadedImage,this.image);


    this.httpClient.post('http://localhost:8080/upload/image/', imageFormData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.postResponse = response;
          this.successResponse = this.postResponse.body.message;
        } else {
          this.successResponse = 'Image not uploaded due to some error!';
        }
      }
      );
  }

  viewImage() {
    this.httpClient.get('http://localhost:8080/get/image/info/' + this.image)
      .subscribe(
        res => {
          this.postResponse = res;
          this.dbImage = 'data:image/jpeg;base64,' + this.postResponse.image;
        }
      );
  }
  

}
