import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addprofile',
  templateUrl: './addprofile.component.html',
  styleUrls: ['./addprofile.component.css']
})
export class AddprofileComponent implements OnInit {
  uploadedImage!: File;
  dbImage: any;
  postResponse: any;
  successResponse!: string;
  image =JSON.parse(sessionStorage.getItem("usermail")|| '{}')
  

  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
  }
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


}
