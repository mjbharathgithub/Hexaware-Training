-- Incidents:
-- • IncidentID (Primary Key)
-- © Hexaware Technologies Limited. All rights www.hexaware.com
-- • IncidentType (e.g., Robbery, Homicide, Theft)
-- • IncidentDate
-- • Location (Geospatial Data: Latitude and Longitude)
-- • Description
-- • Status (e.g., Open, Closed, Under Investigation)
-- • VictimID (Foreign Key, linking to Victims)
-- • SuspectId(Foreign Key, Linking to Suspect)
-- drop table incidents,officers,victims,suspects,law_agencies,evidences,reports;

-- create database crime_analysis_reporting_system;
-- use crime_analysis_reporting_system;
create table Incidents(
	incident_id int primary key auto_increment,
    incident_type  set('Robbery','Homicie','Theft'),
    incident_date timestamp default current_timestamp,
    location varchar(255),
    description text,
    status set('Open','Closed','Under Investigation'),
    victim_id int,
    suspect_id int,
    foreign key(victim_id) references victims(victim_id),
    foreign key(suspect_id) references suspects(suspect_id)
    );



-- select @@foreign_key_checks;
-- set @@foreign_key_checks=0;




-- 17:18:49	create table Incidents(  incident_id int primary key,     incident_type  set('Robbery','Homicie','Theft'),     incident_date date default current_date,     location varchar(255),     description text,     status set('Open','Closed','Under Investigation'),     victim_id int,     suspect_id int,     foreign key(victim_id) references victims(victim_id),     foreign key(suspect_id) references suspects(supspect_id)     )	Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'current_date,     location varchar(255),     description text,     status set('O' at line 4	0.000 sec


-- 2. Victims:
-- • VictimID (Primary Key)
-- • FirstName
-- • LastName
-- • DateOfBirth
-- • Gender
-- • Contact Information (e.g., Address, Phone Number)

create table victims(
	victim_id int primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    date_of_birth date default null,
    gender enum('Male','Female','Others'),
    contact_information text
    );
    
-- 3. Suspects:
-- • SuspectID (Primary Key)
-- • FirstName
-- • LastName
-- • DateOfBirth
-- • Gender
-- • Contact Information

create table suspects(
	suspect_id int primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    date_of_birth date default null,
    gender enum('Male','Female','Others'),
    contact_information text
    );
    
    
-- 4. Law Enforcement Agencies:
-- • AgencyID (Primary Key)
-- • AgencyName
-- • Jurisdiction
-- • Contact Information
-- • Officer(s) (Link to Officers within the agency)

create table law_agencies(
	agency_id int primary key auto_increment,
    Agency_name varchar(255),
    jurisdiction text,
    contact_information text,
    officer_id int,
    foreign key(officer_id) references officers(officer_id)
    );
    
    
-- 5. Officers:
-- © Hexaware Technologies Limited. All rights www.hexaware.com
-- • OfficerID (Primary Key)
-- • FirstName
-- • LastName
-- • BadgeNumber
-- • Rank
-- • Contact Information
-- • AgencyID (Foreign Key, linking to Law Enforcement Agencies)

create table officers(
	officer_id int primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    badge_number int not null,
    officer_rank int,
    contact_information text not null,
    agency_id int,
    foreign key(agency_id) references law_agencies(officer_id)
    );
    
    
-- 6. Evidence:
-- • EvidenceID (Primary Key)
-- • Description
-- • Location Found
-- • IncidentID (Foreign Key, linking to Incidents)

create table evidences(
	evidence_id int primary key auto_increment,
    description text,
    location_found varchar(255),
    incident_id int,
    foreign key(incident_id) references Incidents(incident_id));
    
   -- desc 
-- 7. Reports:
-- • ReportID (Primary Key)practice
-- • IncidentID (Foreign Key, linking to Incidents)
-- • ReportingOfficer (Foreign Key, linking to Officers)
-- • ReportDate
-- • ReportDetails
-- • Status (e.g., Draft, )

	create table reports(
    report_id int primary key auto_increment,
    incident_id int,
    reporting_officer_id int,
    report_date date,
    report_details text,
    status enum('Draft','Finalized'),
    foreign key(incident_id) references incidents(incident_id),
    foreign key(reporting_officer_id) references officers(officer_id)
    
    );