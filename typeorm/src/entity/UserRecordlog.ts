
import {Entity, PrimaryGeneratedColumn, Column, PrimaryColumn} from "typeorm";

@Entity()
export class UserRecordlog {

    @Column()
    id: number;

    @Column()
    userID: number;

    @Column({type:'date'})
    applyDate: Date;

    @Column()
    leaveType: string;

    @Column({type:'date'})
    createdAt: Date;

    @Column()
    createdBy: string;

    @Column({type:'date'})
    updatedAt: Date;

    @Column()
    updatedBy: string;

    @Column()
    updateFrequency: number;

}
