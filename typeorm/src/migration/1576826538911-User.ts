import {MigrationInterface, QueryRunner} from "typeorm";

export class User1576826538911 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "user" ("id" int NOT NULL IDENTITY(1,1), "fullName" nvarchar(255) NOT NULL, "group" int NOT NULL, "totalLeave" int NOT NULL, "status" nvarchar(255) NOT NULL, "access" nvarchar(255) NOT NULL, "createdAt" date NOT NULL, "createdBy" nvarchar(255) NOT NULL, "updatedAt" date NOT NULL, "updatedBy" nvarchar(255) NOT NULL, "updateFrequency" int NOT NULL, CONSTRAINT "PK_cace4a159ff9f2512dd42373760" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "user_log" ("id" int NOT NULL, "fullName" nvarchar(255) NOT NULL, "group" int NOT NULL, "totalLeave" int NOT NULL, "status" nvarchar(255) NOT NULL, "access" nvarchar(255) NOT NULL, "createdAt" date NOT NULL, "createdBy" nvarchar(255) NOT NULL, "updatedAt" date NOT NULL, "updatedBy" nvarchar(255) NOT NULL, "updateFrequency" int NOT NULL, CONSTRAINT "PK_1e59ea7a07b034196b6125487d7" PRIMARY KEY ("id", "updateFrequency"))`, undefined);
        await queryRunner.query(`CREATE TABLE "user_record" ("id" int NOT NULL IDENTITY(1,1), "applyDate" date NOT NULL, "leaveType" nvarchar(255) NOT NULL, "createdAt" date NOT NULL, "createdBy" nvarchar(255) NOT NULL, "updatedAt" date NOT NULL, "updatedBy" nvarchar(255) NOT NULL, "updateFrequency" int NOT NULL, "user_id" int, CONSTRAINT "PK_d0c1972a0031748dfb3c0cba1e1" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "user_recordlog" ("id" int NOT NULL, "userID" int NOT NULL, "applyDate" date NOT NULL, "leaveType" nvarchar(255) NOT NULL, "createdAt" date NOT NULL, "createdBy" nvarchar(255) NOT NULL, "updatedAt" date NOT NULL, "updatedBy" nvarchar(255) NOT NULL, "updateFrequency" int NOT NULL, CONSTRAINT "PK_7675d7018ba7225b27955af9887" PRIMARY KEY ("id", "updateFrequency"))`, undefined);
        await queryRunner.query(`ALTER TABLE "user_record" ADD CONSTRAINT "FK_fcb7329560d49c9b1436de87162" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "user_record" DROP CONSTRAINT "FK_fcb7329560d49c9b1436de87162"`, undefined);
        await queryRunner.query(`DROP TABLE "user_recordlog"`, undefined);
        await queryRunner.query(`DROP TABLE "user_record"`, undefined);
        await queryRunner.query(`DROP TABLE "user_log"`, undefined);
        await queryRunner.query(`DROP TABLE "user"`, undefined);
    }

}
