import React, { Component } from 'react'
import { Grid,Paper,Typography,Button, TextField } from '@material-ui/core'
import validator from 'validator';
import axios from 'axios';

export class AppInstall extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            name1:"",
            address:"",
            email:"",
            phone:"",
            description:"",
            valid:false,
            error:{
                emailError:false,
                eamilErrorDesc:"Email*",
               
            }
            
        };
        

    }
    


    change = e =>{
        let errors = this.state.error;
        this.setState({
            [e.target.name]: e.target.value
        });
        if(e.target.name === "email")
        {
            if(validator.isEmail(this.state.email))
            {
                errors["eamilErrorDesc"]="Email*";
                errors["emailError"]=false;
                this.setState({error:errors})
            }
            else
            {
                errors["eamilErrorDesc"]="Email*: Please type a valid Email address";
                errors["emailError"] = true;
                this.setState({error:errors})

            }

        }
       
        this.setState({
            valid: !(this.state.error.emailError || this.state.error.passwordError || this.state.error.confirmPasswordError || !validator.isLength(this.state.name1, 1,50) || !validator.isLength(this.state.address, 1, 200) || ! validator.isLength(this.state.description, 1, 10000))
        });

        
       
    }
 
    
    submitfunction=()=>
    {
        //var valid = this.handleValidation();
        const orgObject = {
            orgName: this.state.name1,
            address: this.state.address,
            email: this.state.email,
            phone_no: this.state.phone,
            description: this.state.description
        }
        axios.post('/org/', orgObject)
            .then((res) => {
                console.log(res);
            }).catch((error) => {
                console.log(error)
            });
        //this.setState({ username: '', email: '', password: '' })
        console.log(this.state)
    }
    
    
    
    render() {
        const paperStyle = {padding:'30px 20px', width:400, margin:"20px auto"}
        return (
            <div>
                <Grid>
                    <Paper elevation={10} style={paperStyle}>
                        <h2>Organization Setup</h2>
                    <Typography variant='caption'>Fill up the information to setup an organization</Typography>

                    <Grid>
                    <form noValidate autoComplete="off">
                    <div>
                        
                        <TextField
                        //id="outlined-basic"
                        type ="text"
                        fullWidth
                        label="Organization Name*"
                        name = "name1"
                        value={this.state.name}
                        
                        placeholder="Name of Organization"
                        onChange={e => this.change(e)}
                        />
                      
                    </div>
                    <div>
                       
                    <TextField
                        label="Address*"
                        name="address"
                        //id="standard-basic"
                        type ="text"
                        fullWidth
                        placeholder="Physical office Adderess"
                        onChange={e => this.change(e)}

                        />
                     <div>
                        
                     <TextField
                        error={this.state.error.emailError}
                        label={this.state.error.eamilErrorDesc}
                        name="email"
                        //id="standard-basic"
                        type ="email"
                        fullWidth
                        placeholder="Email of the Organization"
                        onChange={e => this.change(e)}

                        />
                      
                    </div>

                    <div>
                        
                    <TextField
                        label="Phone number*"
                        name="phone"
                        //id="standard-basic"
                        type ="tel"
                        placeholder=""
                        onChange={e => this.change(e)}

                        />
                      
                    </div>
                 
                        
                   
                    <div>
                        <Typography variant='caption'>{this.state.error.confirmPasswordErrorDesc}</Typography>
                      
                    </div>
                    <div>
                        
                    <TextField
                        label="Description*"
                        name="description"
                        //id="standard-basic"
                        type ="text"
                        fullWidth
                        multiline
                        rows="4"
                        placeholder="Describe your Organization"
                        onChange={e => this.change(e)}

                        />
                      
                    </div>
                    <br />
                    <br />
                    <div>
                    <Typography variant='caption'>Choose an appropriate picture for your organization</Typography>
                        <input type='file' />

                       
                    </div>
                    <br />
                    <br />

                    <div>
                        <Button disabled={! this.state.valid} variant='contained' color='primary' onClick={this.submitfunction}>Submit</Button>
                    </div>
                      
                    </div>

                </form>

                    </Grid>

                    </Paper>

                
                
                
                </Grid>
            </div>
        )
    }
}

export default AppInstall
